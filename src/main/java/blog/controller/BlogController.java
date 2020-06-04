package blog.controller;

import blog.model.Blog;
import blog.service.IBlogService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BlogController {

    private static Logger logger = LogManager.getLogger(BlogController.class);

    @Autowired
    private IBlogService blogService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView loadIndex(String type) {
        logger.trace("Vao loadIndex()");
        ModelAndView index = null;
        List<Blog> blogList;
        try {
            index = new ModelAndView("index");
            blogList = blogService.findAll();
            logger.info(blogList.toString());
            index.addObject("blogList", blogList);
            switch (type) {
                case "edit":
                    index.addObject("message", "Sua thanh cong");
                    break;
                case "create":
                    index.addObject("message", "Them thanh cong");
                    break;
                case "remove":
                    index.addObject("message", "Xoa thanh cong");
                    break;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        logger.trace("Thoat loadIndex()");
        return index;
    }

    @RequestMapping(value = "/blog/edit/{id}", method = RequestMethod.GET)
    public ModelAndView loadFormEdit(@PathVariable("id") int id) {
        logger.trace("Vao loadFormEdit()");
        ModelAndView editForm = null;
        Blog blog;
        try {
            editForm = new ModelAndView("edit");
            blog = blogService.findById(id);
            editForm.addObject("blog", blog);

            logger.info(blog.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        logger.trace("Thoat loadFormEdit()");
        return editForm;
    }

    @RequestMapping(value = "/blog/edit/{id}", method = RequestMethod.POST)
    public ModelAndView editFormToIndex(@ModelAttribute("blog") Blog blog) {
        logger.trace("Vao editFormToIndex()");
        ModelAndView backToIndex = null;
        try {
            blogService.save(blog);
            backToIndex = loadIndex("edit");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return backToIndex;
    }

    @RequestMapping(value = "/blog/view_details/{id}", method = RequestMethod.GET)
    public ModelAndView loadDetails(@PathVariable("id") int id) {
        logger.trace("Vao loadDetails()");
        ModelAndView detail = null;
        Blog blog;
        try {
            blog = blogService.findById(id);
            logger.info(blog.toString());
            detail = new ModelAndView("details");
            detail.addObject("blog", blog);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        logger.trace("Thoat loadDetails()");
        return detail;
    }

    @RequestMapping(value = "/blog/delete/{id}", method = RequestMethod.GET)
    public ModelAndView loadDelete(@PathVariable("id") int id) {
        logger.trace("Vao loadDelete()");
        ModelAndView delete = null;
        try {
            blogService.remove(id);
            logger.info("ID = "+id);
            delete = loadIndex("remove");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        logger.trace("Thoat loadDelete()");
        return delete;
    }

    @RequestMapping(value = "/blog/create_blog", method = RequestMethod.GET)
    public ModelAndView loadCreateForm() {
        logger.trace("Vao loadCreateForm()");
        ModelAndView createForm = null;
        Blog blog;
        try {
            createForm = new ModelAndView("create");
            blog = new Blog();
            createForm.addObject("blog", blog);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        logger.trace("Thoat loadCreateForm()");
        return createForm;
    }

    @RequestMapping(value = "/blog/create_blog", method = RequestMethod.POST)
    public ModelAndView createToIndex(@ModelAttribute("blog") Blog blog) {
        logger.trace("Vao createToIndex()");
        ModelAndView create = null;
        try {
            blogService.save(blog);
            create = loadIndex("create");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        logger.trace("Thoat createToIndex()");
        return create;
    }
}
