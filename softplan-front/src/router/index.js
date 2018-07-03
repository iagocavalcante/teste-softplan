import Vue from 'vue'
import Router from 'vue-router'
import CustoTransporte from '@/features/custo-transporte'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'CustoTransporte',
      component: CustoTransporte
    }
  ]
})
