package com.isladellago.apartmentmanager.service;

public interface TokenService {

    /**
     * This method validates the given token.
     *
     * @param token Token to be validated.
     * @return If the token is valid.
     */
    boolean validate(String token);

    /**
     * Get the email from the given token.
     *
     * @param token Given validated token.
     * @return Email from the token payload.
     */
    String getEmailFromToken(String token);
}
