package net.efcrafterz.exam_ShopPlugin

import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerInteractEvent

class EventListener: Listener{
    @EventHandler
    fun onClick(e: PlayerInteractEvent) {
        e.player.sendMessage("aaaaaaaaa")

        val lore = listOf("§7この剣は強力な力を持っている", "§6冒険に必須のアイテム")
        val item = Item(Material.DIAMOND_SWORD, "§6最強ソード")
        e.player.inventory.addItem(item.get())

//        val inv: Inventory = Bukkit.createInventory(e.player, 9, "Custom Inventory")
//
//        // アイテムを設定（例: ダイヤモンドをインベントリに追加）
//        val item = ItemStack(Material.DIAMOND)
//        val meta = item.itemMeta
//        meta?.setDisplayName("Click Me!") // アイテム名を変更
//        item.itemMeta = meta
//
//        inv.setItem(4, item) // インベントリの中央にダイヤモンドをセット
//
//        e.player.openInventory(inv) // インベントリを開く
    }
}
