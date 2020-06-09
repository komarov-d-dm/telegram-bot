package com.telegram.bot;

import com.telegram.bot.bots.RecipeBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

@RestController
public class RecipeController {
    private final RecipeBot telegramBot;

    @Autowired
    public RecipeController(RecipeBot telegramBot) {
        this.telegramBot = telegramBot;
    }

    @PostMapping("/")
    public BotApiMethod<?> onUpdateReceived( Update update) {
        return telegramBot.onWebhookUpdateReceived(update);
    }
}
