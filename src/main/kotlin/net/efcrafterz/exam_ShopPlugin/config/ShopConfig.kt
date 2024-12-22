package net.efcrafterz.exam_ShopPlugin.config

import net.efcrafterz.exam_ShopPlugin.Exam_ShopPlugin
import net.efcrafterz.exam_ShopPlugin.inventoryitem.PurchasableItem
import net.efcrafterz.exam_ShopPlugin.Item
import net.efcrafterz.exam_ShopPlugin.Shop
import org.bukkit.Material
import java.util.*
import kotlin.collections.HashMap

class ShopConfig(private val plugin: Exam_ShopPlugin, private val filename: String)
    : ConfigManager(plugin, filename) {

    val dataMap: HashMap<String, Shop> = HashMap()

    private val AMOUNT = "amount"
    private val PRICE = "price"

    init {
        try {
            load()
        } catch (e: Exception) {
            dataMap.clear()
            e.printStackTrace()
        }
    }

    override fun load() {
        val config = getConfig()

        for (shopKey in config.getKeys(false)) {
            val shopSection = config.getConfigurationSection(shopKey) ?: throw IllegalArgumentException("shopSectionの読み込みに失敗しました")
            val shopName = shopSection.getString("name") ?: throw IllegalArgumentException("shopNameの読み込みに失敗しました")
            plugin.logger.warning("ショップ名: $shopKey")

            val itemList = config.getList("$shopKey.items") as? List<Map<String, Map<String, Any>>> ?: throw IllegalArgumentException("itemListの読み込みに失敗しました")
            val items: MutableList<PurchasableItem> = mutableListOf()
            for (item in itemList) {
                for ((itemName, itemData) in item) {
                    val amount = itemData[AMOUNT] as? Int ?: throw IllegalArgumentException("amountの読み込みに失敗しました")
                    val price = itemData[PRICE] as? Int ?: throw IllegalArgumentException("priceの読み込みに失敗しました")

                    plugin.logger.info("アイテム: $itemName, 数量: $amount, 価格: $price")
                    items += PurchasableItem(Item(Material.valueOf(itemName.uppercase(Locale.getDefault()))), price, amount)
                }
            }
            dataMap[shopKey] = Shop(shopName, items)
        }
    }

}
