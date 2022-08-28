package com.talkfree.talkfreebackend.repository;

import com.talkfree.talkfreebackend.entity.LoginTicket;

public interface LoginTicketRepository {

    LoginTicket findLoginTicketBySessionId(String sessionId);
    int addLoginTicket(LoginTicket loginTicket);
}
