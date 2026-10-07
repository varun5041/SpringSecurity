
package com.security.learn.securityProject.Controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    // ADMIN only
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/route1")
    public String route1() {
        return "change menu";
    }

    // ADMIN only
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/route2")
    public String route2() {
        return "Change Price";
    }

    // ADMIN or GUEST
    @PreAuthorize("hasAnyRole('ADMIN', 'GUEST')")
    @GetMapping("/route3")
    public String route3() {
        return "Order!";
    }

    // ADMIN or GUEST
    @PreAuthorize("hasAnyRole('ADMIN', 'GUEST')")
    @GetMapping("/route4")
    public String route4() {
        return "pay bill";
    }

    // ADMIN or GUEST
    @PreAuthorize("hasAnyRole('ADMIN', 'GUEST')")
    @GetMapping("/route5")
    public String route5() {
        return "drinking water!";
    }
}
