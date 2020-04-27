package ru.ilyafilim.testing.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.util.Locale;

@Service
public class DialogServiceImpl implements DialogService {

    private final MessageSource messagesSource;

    public DialogServiceImpl(MessageSource messagesSource) {
        this.messagesSource = messagesSource;
    }

    @Override
    public String getDialogContent(String dialog, String[] params) {
        return messagesSource.getMessage(dialog, params, Locale.ROOT);
        //return messagesSource.getMessage(dialog, params, Locale.forLanguageTag("ru-RU"));
    }
}
