package com.learnist.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TitleController {

    private static final String TITLE = "title";

    @GetMapping
    public String getWelcomePage(final Model model) {
        model.addAttribute(TITLE, "Welcome | Learnist");
        return "welcome";
    }

    @GetMapping(value = "/main")
    public String getMainPage(final Model model) {
        model.addAttribute(TITLE, "Main | Learnist");
        return "main";
    }

    @GetMapping(value = "/forgetPassword")
    public String getForgetPasswordPage(final Model model) {
        model.addAttribute(TITLE, "Forgot | Learnist");
        return "forgetPassword";
    }

    @GetMapping(value = "/registration")
    public String getRegistrationPage(final Model model) {
        model.addAttribute(TITLE, "Registration | Learnist");
        return "registration";
    }

    @GetMapping(value = "/login")
    public String getLogin(final Model model) {
        model.addAttribute(TITLE, "Login | Learnist");
        return "login";
    }

    @GetMapping("/login-error")
    public String getLoginErrorPage(final Model model) {
        model.addAttribute("loginError", true);
        model.addAttribute(TITLE, "Error | Learnist");
        return "error";
    }

    @GetMapping(value = "/perform_logout")
    public final String getLogoutPage(final Model model) {
        model.addAttribute(TITLE, "Logout | Learnist");
        return "login";
    }

    @GetMapping(value = "/admin/profile")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String getAdminPage(final Model model) {
        model.addAttribute(TITLE, "Admin | Learnist");
        return "admin";
    }

    @GetMapping(value = "/creator/profile")
    @PreAuthorize("hasAuthority('can_update')")
    public String getCreatorPage(final Model model) {
        model.addAttribute(TITLE, "Creator | Learnist");
        return "creator";
    }

    @GetMapping(value = "/dictionary/list")
    public String getDictionaryList(final Model model) {
        model.addAttribute(TITLE, "Dictionary | Learnist");
        return "dictionary/list";
    }

    @GetMapping(value = "/other-materials/list")
    public String getOtherMaterialsList(final Model model){
        model.addAttribute(TITLE, "Other | Learnist");
        return "otherMaterials/list";
    }

    @GetMapping(value = "/training/list")
    public String getTrainingList(final Model model){
        model.addAttribute(TITLE, "Training | Learnist");
        return "trainings/list";
    }

    @GetMapping(value = "/task/list")
    public String getTaskList(final Model model) {
        model.addAttribute(TITLE, "Tasks | Learnist");
        return "task/list";
    }

    @GetMapping(value = "/user/add")
    public String getUserPage(final Model model) {
        model.addAttribute(TITLE, "Add | Learnist");
        return "users/user";
    }

    @GetMapping(value = "/user/profile")
    public String getUserProfile(final Model model){
        model.addAttribute(TITLE, "Profile | Learnist");
        return "users/user";
    }

    @GetMapping(value = "/user/profile-settings")
    public String getUserProfileSettings(final Model model){
        model.addAttribute(TITLE, "Settings | Learnist");
        return "users/userProfileSettings";
    }
}
