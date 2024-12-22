package net.efcrafterz.exam_ShopPlugin

import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import java.util.*

class CommandHandler(private val plugin: Exam_ShopPlugin) {
    // コマンドの実装
    fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>?): Boolean {
        val player = sender as Player
        val argsCount = args?.size ?: 0

        return when (command.name.lowercase(Locale.getDefault())) {
            "shop" -> openShop(player, argsCount, args)
            else -> false
        }
    }

    private fun openShop(player: Player, argsCount: Int, args: Array<out String>?): Boolean {
        if (argsCount <= 0) { return false }

        ShopController(args!![0], plugin.shopConfig).open(player)
        player.sendMessage("open shop [${args[0]}]")

        return true
    }
}