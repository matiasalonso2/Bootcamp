package com.desafiospring.dto;

public class PurchaseResponseDTO {
    private TicketDTO ticket;
    private StatusCodeDTO statusCode;

    public PurchaseResponseDTO(TicketDTO ticket, StatusCodeDTO statusCode) {
        this.ticket = ticket;
        this.statusCode = statusCode;
    }

    public StatusCodeDTO getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(StatusCodeDTO statusCode) {
        this.statusCode = statusCode;
    }

    public TicketDTO getTicket() {
        return ticket;
    }

    public void setTicket(TicketDTO ticket) {
        this.ticket = ticket;
    }
}
