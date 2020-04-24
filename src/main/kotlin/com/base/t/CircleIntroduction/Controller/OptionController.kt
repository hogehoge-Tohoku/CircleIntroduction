package com.base.t.CircleIntroduction.Controller

import com.base.t.CircleIntroduction.Domain.ConditionalForm
import com.base.t.CircleIntroduction.Service.OptionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.ModelMap
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.servlet.mvc.support.RedirectAttributes


@Controller
class OptionController {

    @Autowired
    lateinit var optionService: OptionService

    var checkClassification = mutableMapOf<String, String>()
    var checkOrganization = mutableMapOf<String, String>()

    private fun initCheckClassification(): MutableMap<String, String> {
        val check = mutableMapOf<String, String>()
        //TODO:ちゃんとしたやつにする
        check["学友会"] = "学友会"
        check["サークル"] = "サークル"
        check["自主ゼミ"] = "自主ゼミ"
        return check
    }

    private fun initCheckOrganization(): MutableMap<String, String> {
        val check = mutableMapOf<String, String>()
        check["全学"] = "全学"
        check["医学部"] = "医学部"
        check["経済学部"] = "経済学部"
        check["法学部"] = "法学部"
        return check
    }

    @GetMapping("/option")
    fun getOption(@ModelAttribute form: ConditionalForm?, model: Model): String {
        checkClassification = initCheckClassification()
        checkOrganization = initCheckOrganization()
        model.addAttribute("checkClassification", checkClassification)
        model.addAttribute("checkOrganization", checkOrganization)
        return "option"
    }

    @PostMapping("/option")
    fun postOption(redirectAttributes: RedirectAttributes,
                   @ModelAttribute @Validated form: ConditionalForm?,
                   bindingResult: BindingResult,
                   model: Model): String {
        if(bindingResult.hasErrors()){
            return getOption(form, model)
        }
        println(form)
        if (form != null) {
            val optionalCircle = optionService.conditionalSelect(form.conditionalClassification, form.conditionalOrganization)
            val optionalCount = optionService.conditionalCount(form.conditionalClassification, form.conditionalOrganization)
            val modelMap = ModelMap()
                    .addAttribute("optionalCircle", optionalCircle)
                    .addAttribute("optionalCount", optionalCount)
            redirectAttributes.addFlashAttribute("model", modelMap)
        }

        return "redirect:/"
    }
}