import Vue from "vue";
import Router from "vue-router";
import Home from "./views/Home.vue";

Vue.use(Router);

export default new Router({
  mode: "history",
  base: process.env.BASE_URL,
  routes: [
    {
      path: "/",
      name: "home",
      component: Home
    },
    {
      path: "/about",
      name: "about",
      // route level code-splitting
      // this generates a separate chunk (about.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import(/* webpackChunkName: "about" */ "./views/About.vue")
    },
    {
      path: "/admin/cal",
      name: "admin-cal",
      // route level code-splitting
      // this generates a separate chunk (about.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import(/* webpackChunkName: "cal" */ "./views/admin/Cal.vue")
},
    {
      path: "/movie",
      name: "movie",
      component: () =>
        import("./views/MovieTemplate.vue")
    },
    {
      path: "/admin",
          name: "admin",
        component: () =>
      import("./views/adminPage.vue")
    },
    {
      path: "/admin/CarouselManagement",
          name: "admin-carousel",
        component: () =>
      import("./views/admin/CarouselManagement.vue")
    },
    {
      path: "/admin/Movie",
          name: "admin-movies",
          component: () =>
      import("./views/admin/Movie/Movies.vue")
    },
    {
        path: "/admin/Movie/add",
            name: "admin-movie-add",
        component: () =>
        import("./views/admin/Movie/add.vue")
    },
    {
        path: "/admin/Movie/:movieID",
            name: "admin-movie",
        component: () =>
        import("./views/admin/Movie/MovieEdit.vue")
    },
    {
      path: "/admin/OrderManagement",
          name: "admin-order",
        component: () =>
      import("./views/admin/OrderManagement.vue")
    },
    {
      path: "/admin/ScheduleManagement",
          name: "admin-schedule",
        component: () =>
      import("./views/admin/ScheduleManagement.vue")
    },
    {
      path: "/admin/TheatreManagement",
          name: "admin-theatre",
        component: () =>
      import("./views/admin/TheatreManagement.vue")
    }
  ]
});
