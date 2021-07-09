package com.spring.codeblog.controller;

import com.spring.codeblog.model.Post;
import com.spring.codeblog.service.CodeblogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

//Representa o Servelet
@Controller
public class CodeblogController {

    @Autowired
    CodeblogService codeblogService;

    //Metodo GET HTTP
    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public ModelAndView getPosts(){
        ModelAndView mv = new ModelAndView("posts"); //Nome da tela que irá retornar
        List<Post> posts = codeblogService.findAll();
        mv.addObject("posts", posts); //Setando o atributo para capturar lá na View
        return mv;
    }

    //Metodo GET HTTP
    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public ModelAndView getPostDetails(@PathVariable("id") long id){
        ModelAndView mv = new ModelAndView("postDetails"); //Nome da tela que irá retornar
        Post post = codeblogService.findById(id);
        mv.addObject("post", post); //Setando o atributo para capturar lá na View
        return mv;
    }

    //Retorna a página postForm
    @RequestMapping(value = "/newpost", method = RequestMethod.GET)
    public String getPostForm(){
        return "postForm";
    }

    //Recebe o Novo post e salva no banco de dados
    @RequestMapping(value = "/newpost", method = RequestMethod.POST)
    public String savePost(@Valid Post post, BindingResult result, RedirectAttributes attributes){

        //Caso tenha algum erro, FALTA DE CAMPO PREENCHIDO
        if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos!");
            return "redirect:/newpost";
        }
        //Salvanado Post no DB
        //DateTimeFormatter dfd = DateTimeFormatter.ofPattern("dd/MM/yy");
        //.format()
        post.setData(LocalDate.now());
        codeblogService.save(post);
        return "redirect:/posts";
    }
}
