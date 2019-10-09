package ua.od.telegrambot;

import java.io.File;
import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class HealthBot extends TelegramLongPollingBot {

	public void onUpdateReceived(Update update) {
		if (update.hasMessage() && update.getMessage().hasText()) {
			SendMessage message = new SendMessage() // Create a SendMessage object with mandatory fields
					.setChatId(update.getMessage().getChatId()).setText("Ваше сообщение <b>такое</b> " + update.getMessage().getText()).enableHtml(true);
			System.out.println(update.getMessage().getChatId());
			System.out.println(update.getMessage().getText());
			//File file = new File("/images/pic.png");
			File file = null;
			try {
				file = new ClassPathResource("static/images/pic.png").getFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			SendPhoto photo = new SendPhoto().setPhoto(file).setChatId(update.getMessage().getChatId());
			
			try {
				execute(message);
				execute(photo);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
		}

	}

	public String getBotUsername() {
		// TODO Auto-generated method stub
		return "Healthfoodbot";
	}

	@Override
	public String getBotToken() {
		// TODO Auto-generated method stub
		return "895382212:AAFog4m3dNdLdTch-fpr_gesILM6wpI72zo";
	}

}
