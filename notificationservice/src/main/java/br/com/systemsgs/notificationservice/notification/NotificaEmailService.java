package br.com.systemsgs.notificationservice.notification;

import java.util.List;

public interface NotificaEmailService<T> {

    void notificaEmail(List<T> dadosNotificacao);

}
