package net.efcrafterz.exam_ShopPlugin

import net.efcrafterz.exam_ShopPlugin.InvItemClasses.BackItem
import net.efcrafterz.exam_ShopPlugin.InvItemClasses.ForwardItem
import net.efcrafterz.exam_ShopPlugin.InvItemClasses.PurchasableItem
import org.bukkit.Material
import org.bukkit.entity.Player
import xyz.xenondevs.invui.gui.Gui
import xyz.xenondevs.invui.gui.PagedGui
import xyz.xenondevs.invui.gui.structure.Markers
import xyz.xenondevs.invui.item.builder.ItemBuilder
import xyz.xenondevs.invui.item.impl.SimpleItem
import xyz.xenondevs.invui.window.Window

class ShopController(private val player: Player, private val shopId: String) {

    init {
        view()
    }

    fun view() {
        player.sendMessage(shopId)

        val item = Item(Material.DIAMOND, "§6最強ソード",
            listOf("§7この剣は強力な力を持っている", "§6冒険に必須のアイテム"))

        player.inventory.addItem(item.get())


        val items = listOf(
            PurchasableItem(item, 100, 1)
            )

        // for

        val border = Item(Material.GRAY_STAINED_GLASS_PANE, "").get()

// create the gui
        val gui = PagedGui.items()
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
            .setContent(items)
            .build()

        val window = Window.single()
            .setViewer(player)
            .setTitle("InvUI")
            .setGui(gui)
            .build()

        window.open()
    }





    fun view2() {
        player.sendMessage(shopId)

        val item = Item(Material.DIAMOND, "§6最強ソード",
            listOf("§7この剣は強力な力を持っている", "§6冒険に必須のアイテム"))
        player.inventory.addItem(item.get())

        val gui = Gui.normal()
            .setStructure(
                "# # # # # # # # #",
                "# d . . . . . . #",
                "# . . . . . . . #",
                "# # # # # # # # #"
            )
            .addIngredient('#', SimpleItem(ItemBuilder(Material.BLACK_STAINED_GLASS_PANE)))
            .addIngredient('d', PurchasableItem(item, 100, 1))
            .build()

        val window = Window.single()
            .setViewer(player)
            .setTitle("InvUI")
            .setGui(gui)
            .build()

        window.open()
    }
}