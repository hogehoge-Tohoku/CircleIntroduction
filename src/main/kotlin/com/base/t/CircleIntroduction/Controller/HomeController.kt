package com.base.t.CircleIntroduction.Controller

import com.base.t.CircleIntroduction.Domain.Circle
import com.base.t.CircleIntroduction.Service.HomeService
import com.base.t.CircleIntroduction.Service.OptionService
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
    @Autowired
    lateinit var optionService: OptionService

    @GetMapping("/")
    fun getHome(@ModelAttribute("model") modelMap: ModelMap, model: Model): String {

        val optionCircleList = modelMap["optionalCircle"]
        val optionalCount = modelMap["optionalCount"]
        print(optionCircleList)
        val circleList = homeService.selectAll()
        if(optionCircleList == null) {
            model.addAttribute("circleList", circleList)
            val count = homeService.count()
            model.addAttribute("count", count)
        }else {
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
        model.addAttribute("form", form)
        return "circleDetail"
    }

}