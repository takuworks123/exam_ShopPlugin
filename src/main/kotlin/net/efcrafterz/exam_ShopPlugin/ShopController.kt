package net.efcrafterz.exam_ShopPlugin

import net.efcrafterz.exam_ShopPlugin.config.ShopConfig
import net.efcrafterz.exam_ShopPlugin.inventoryitem.BackItem
import net.efcrafterz.exam_ShopPlugin.inventoryitem.ForwardItem
import org.bukkit.Material
import org.bukkit.entity.Player
import xyz.xenondevs.invui.gui.PagedGui
import xyz.xenondevs.invui.gui.structure.Markers
import xyz.xenondevs.invui.window.Window
import xyz.xenondevs.invui.item.Item as ItemInvUI

class ShopController(private val shopId: String, private val shopConfig: ShopConfig) {

    private val gui: PagedGui<ItemInvUI>
    private val shop = shopConfig.dataMap[shopId] ?: Shop()

    init {
        val item = Item(Material.DIAMOND_SWORD, "§6最強ソード",
            listOf("§7この剣は強力な力を持っている", "§6冒険に必須のアイテム"))

        val border = Item(Material.GRAY_STAINED_GLASS_PANE, "").get()

// create the gui
        gui = PagedGui.items()
            .setStructure(
                "# # # # # # # # #",
                "# x x x x x x x #",
                "# x x x x x x x #",
                "# x x x x x x x #",
                "# x x x x x x x #",
                "# < # # # # # > #")
            .addIngredient('x', Markers.CONTENT_LIST_SLOT_HORIZONTAL) // where paged items should be put
            .addIngredient('#', border)
            .addIngredient('<', BackItem())
            .addIngredient('>', ForwardItem())
            .setContent(shop.items)
            .build()
    }

    fun open(player: Player) {
        val window = Window.single()
            .setViewer(player)
            .setTitle(shop.name)
            .setGui(gui)
            .build()

        window.open()
    }
}