import { createRouter, createWebHashHistory } from 'vue-router'

import Eliminar from '../components/Eliminar.vue'
import Estudiante from '../components/Estudiante.vue'
import Guardar from '../components/Guardar.vue'
import BienvenidaPage from '../components/BienvenidaPage.vue'

const routes = [
    {
        path: '/eliminar',
        component: Eliminar
    },
    {
        path: '/estudiante',
        component: Estudiante
    },
    {
        path: '/guardar',
        component: Guardar
    },
    {
        path: '/',
        component: BienvenidaPage
    },
]

const router = createRouter({
    history: createWebHashHistory(),
    routes
})

export default router