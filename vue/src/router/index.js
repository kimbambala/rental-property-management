import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import Register from '../views/Register.vue'
import store from '../store/index'
import DetailsView from '../views/DetailsView.vue'
import AccountView from '../views/AccountView.vue'
import ListingView from '../views/ListingView.vue'
import EditListing from '../views/EditListing.vue'
import AssignRenter from '../views/AssignRenter.vue'
import ContactOwner from '../views/ContactOwnerView.vue'
import RentUnitView from '../views/RentUnitView'

Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },


    {
      path: "/details/:propertyId",
      name: "details",
      component: DetailsView,
      meta: {
        requiresAuth: false
      }
    },

    {
      path: "/account/:id",
      name: "account",
      component: AccountView,
      meta: {
        requiresAuth: true
      }
    },

    {
      path: "/listings/create/:id",
      name: "listings",
      component: ListingView,
      meta: {
        requiresAuth: true
      }
    },

    {
      path: "/listings/edit/:propertyId",
      name: "edit-listing",
      component: EditListing,
      meta: {
        requiresAuth: true
      }
    },

    {
      path: "/listings/assign/:propertyId",
      name: "assign-renter",
      component: AssignRenter,
      meta: {
        requiresAuth: true
      }
    },

    {
      path: "/contact-owner/:propertyId",
      name: "contact-owner",
      component: ContactOwner,
      meta: {
        requiresAuth: true
      }

    },

    {
      path: "/rent-unit",
      name: "rent-unit",
      component: RentUnitView,
      meta: {
        requiresAuth: true
      }

    },



  ]
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    next("/login");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
