package org.side.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HommeController {



        @GetMapping
        public String index() {
            return "index";
        }


        @GetMapping("/contact")
        public String contact() {
            return "contact";
        }


        @GetMapping("/privacy")
        public String privacy() {
            return "privacy";
        }


    }