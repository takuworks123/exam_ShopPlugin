package net.efcrafterz.exam_ShopPlugin

import net.efcrafterz.exam_ShopPlugin.config.ShopConfig
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.plugin.java.JavaPlugin
import xyz.xenondevs.invui.InvUI

class Exam_ShopPlugin : JavaPlugin() {

    val shopConfig: ShopConfig = ShopConfig(this, "shop.yml")
    private val commandHandler = CommandHandler(this)

    override fun onEnable() {
        // Plugin startup logic
        logger.warning("testtt")

        saveDefaultConfig()
        logger.severe(config.getString("testt"))

        loadConfig()


        InvUI.getInstance().setPlugin(this);

        server.pluginManager.registerEvents(EventListener(), this)
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>?): Boolean {
        return commandHandler.onCommand(sender, command, label, args)
    }

    private fun loadConfig() {

    }
}
