package com.buddy.selan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@Controller public class HomeController
{

    @RequestMapping("/home") public String viewHome( Model model )
    {

        model.addAttribute( "appName", "Admin" );
        return "home";
    }

    // Login form
    @RequestMapping("/login") public String viewLogin( Model model )
    {

        return "login";
    }

    // Login form with error
    @RequestMapping("/login-error") public String loginError( @RequestParam(value = "error", required = false) String error, Model model )
    {
        if( error.equals( "true" ) )
        {
            model.addAttribute( "loginError", true );
        }
        else
        {
            model.addAttribute( "loginError", false );
        }

        return "login";
    }

    // Login form action
    @PostMapping("/postEndpoint") public String pidUserSubmit( @RequestParam(name = "username") String username, @RequestParam(name = "password") String password )
    {

        if( username.equals( "admin" ) && password.equals( "admin" ) )
        {
            return "redirect:/home";
        }
        else
        {
            return String.format( "redirect:/login-error?error=%s", "true" );
        }
    }
}