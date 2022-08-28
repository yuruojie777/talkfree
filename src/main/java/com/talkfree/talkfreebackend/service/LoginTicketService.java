package com.talkfree.talkfreebackend.service;

import com.talkfree.talkfreebackend.entity.LoginTicket;
import org.springframework.stereotype.Service;

@Service
public interface LoginTicketService {

    LoginTicket getLoginTicketBySessionId(String sessionId);
    int addLoginTicketBySessionId(LoginTicket loginTicket);
}
