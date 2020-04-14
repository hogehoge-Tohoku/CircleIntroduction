package com.base.t.CircleIntroduction.Controller

import com.base.t.CircleIntroduction.Service.HomeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping


@Controller
class HomeController {

    @Autowired
    lateinit var homeService: HomeService

    @GetMapping("/home")
    fun getHome(model: Model): String {
        val circleList = homeService.selectAll()
        model.addAttribute("circleList", circleList)

        val count = homeService.count()
        model.addAttribute("count", count)
        return "home"
    }

}