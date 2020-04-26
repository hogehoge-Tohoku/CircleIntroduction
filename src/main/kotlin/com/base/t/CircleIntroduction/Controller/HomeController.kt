package com.base.t.CircleIntroduction.Controller

import com.base.t.CircleIntroduction.Domain.Circle
import com.base.t.CircleIntroduction.Service.HomeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable


@Controller
class HomeController {

    @Autowired
    lateinit var homeService: HomeService

    @GetMapping("/")
    fun getHome(@ModelAttribute("model") modelMap: ModelMap, model: Model): String {

        val optionCircleList = modelMap["optionalCircle"]
        val flag = modelMap["flag"]
        println(optionCircleList)
        if(optionCircleList == null || flag == true) {
            val circleList = homeService.selectAll()
            model.addAttribute("circleList", circleList)
            val count = homeService.count()
            model.addAttribute("count", count)
        }else {
            val optionalCount = modelMap["optionalCount"]
            model.addAttribute("circleList", optionCircleList)
            model.addAttribute("count", optionalCount)
        }
        return "home"
    }

    @GetMapping("/circleDetail/{id}")
    fun getDetail(@ModelAttribute form: Circle, model: Model, @PathVariable id: Int):String {
        val circle = homeService.selectOne(id)
        form.id = circle.id
        form.name = circle.name
        form.organization = circle.organization
        form.introduction = circle.introduction
        form.pictureName = circle.pictureName
        form.pictureNum = circle.pictureNum
        model.addAttribute("form", form)
        return "circleDetail"
    }
}