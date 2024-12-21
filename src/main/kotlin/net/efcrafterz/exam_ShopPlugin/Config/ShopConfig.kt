package net.efcrafterz.exam_ShopPlugin.Config

import net.efcrafterz.exam_ShopPlugin.Exam_ShopPlugin

class ShopConfig(private val plugin: Exam_ShopPlugin, private val filename: String)
    : ConfigManager(plugin, filename) {

    val shopMap: HashMap<String, List<Any>> = HashMap()

    init {
        load()
    }

    override fun load() {
        val config = getConfig()

        for (shopKey in config.getKeys(false)) {
            val shopSection = config.getConfigurationSection(shopKey)

            if (shopSection == null) { continue }
            val shopName = shopSection.getString("name") ?: continue
            plugin.logger.warning("ショップ名: $shopName")

            val itemsSection = shopSection.getConfigurationSection("items")
            if (itemsSection == null) { continue }
            for (itemKey in itemsSection.getKeys(false)) {
                // アイテム名（例: stone, stone_sword）を取得
                val itemData = itemsSection.getConfigurationSection(itemKey)
                val amount = itemData?.getInt("amount") ?: continue
                val price = itemData?.getInt("price") ?: continue

                // アイテム情報を表示
                plugin.logger.info("アイテム: $itemKey, 数量: $amount, 価格: $price")
            }
        }
    }

}