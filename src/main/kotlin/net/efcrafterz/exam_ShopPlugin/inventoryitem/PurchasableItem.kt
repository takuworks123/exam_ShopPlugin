package net.efcrafterz.exam_ShopPlugin.inventoryitem

import net.efcrafterz.exam_ShopPlugin.Item
import org.bukkit.entity.Player
import org.bukkit.event.inventory.ClickType
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.inventory.ItemStack
import xyz.xenondevs.invui.item.ItemProvider
import xyz.xenondevs.invui.item.builder.ItemBuilder
import xyz.xenondevs.invui.item.impl.AbstractItem

class PurchasableItem(private val purchaseItem: Item, private val price: Int, private val amount: Int): AbstractItem() {

    override fun getItemProvider(): ItemProvider {
        val lore = purchaseItem.getLore()
        val purchaseLore = mutableListOf("§f価格: §6$price", "§f個数: $amount")

        if (lore.isNotEmpty()) {
            purchaseLore += listOf("", "§7-- 説明 --")
            purchaseLore += lore
        }

        // アイテムのメタデータに説明文を設定
        purchaseItem.setLore(purchaseLore)

        return ItemBuilder(purchaseItem.get())
    }

    override fun handleClick(clickType: ClickType, player: Player, event: InventoryClickEvent) {
        if (clickType.isLeftClick) {
            player.sendMessage("購入処理")
            notifyWindows()
        }
    }

    fun get(): ItemStack {
        return purchaseItem.get()
    }
}