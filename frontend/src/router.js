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
        path: "/user/order",
            name: "user-orders",
        component: () =>
        import("./views/user/Order/Orders.vue")
    },
    {
        path: "/user/order/:orderID",
            name: "user-order",
        component: () =>
        import("./views/user/Order/Order.vue")
    },
    {
        path: "/screening/:screeningID",
            name: "screening-order",
        component: () =>
        import("./views/Screening.vue")
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
        path: "/admin/CarouselItem",
            name: "admin-carousel-items",
        component: () =>
        import("./views/admin/CarouselItem/CarouselItem.vue")
    },
    {
        path: "/admin/CarouselItem/add",
            name: "admin-carousel-item-add",
        component: () =>
        import("./views/admin/CarouselItem/add.vue")
    },
    {
        path: "/admin/CarouselItem/:carouselItemID",
            name: "admin-carousel-item",
        component: () =>
        import("./views/admin/CarouselItem/CarouselItemEdit.vue")
    },
    {
      path: "/admin/Order",
          name: "admin-orders",
        component: () =>
      import("./views/admin/Order/Orders.vue")
    },
    {
      path: "/admin/TheatreManagement",
          name: "admin-theatre",
        component: () =>
      import("./views/admin/TheatreManagement.vue")
    }
  ]
});
