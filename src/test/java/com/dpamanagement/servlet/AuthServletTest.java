package com.dpamanagement.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class AuthServletTest {

    AuthServlet auth = new AuthServlet ();

    @BeforeEach
    void setUp ( ) {
    }

    @Test
    void doGet ( ) throws ServletException, IOException {
        HttpServletRequest request = null;
        HttpServletResponse response = null;
    }

    @Test
    void doPost ( ) {
    }
}