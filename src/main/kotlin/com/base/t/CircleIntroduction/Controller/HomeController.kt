package com.base.t.CircleIntroduction.Controller

import com.base.t.CircleIntroduction.Entity.Circle
import com.base.t.CircleIntroduction.Service.HomeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable


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

    @GetMapping("/circleDetail/{id}")
    fun getDetail(@ModelAttribute form: Circle, model: Model, @PathVariable id: Int):String {
        val circle = homeService.selectOne(id)
        form.id = circle.id
        form.name = circle.name
        form.organization = circle.organization
        form.introduction = circle.introduction
        model.addAttribute("form", form)
        return "circleDetail"
    }

}