package br.com.fiap.techChallenge4.usecases;

import lombok.Data;

@Data
public class ClientResponse {

    private Long idClient;
    private AddressResponse address;

    @Data
    public static class AddressResponse{
        private String postalCode;
    }
}
