package com.rentalsystem.review;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/review", "/reviews"})
public class ReviewController {

    @GetMapping({"/list", "/view"})
    public String viewReviews() {
        return "review/view-reviews";
    }

    @GetMapping("/submit")
    public String submitReview() {
        return "review/submit-review";
    }
}