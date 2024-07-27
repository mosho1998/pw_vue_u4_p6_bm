import { createRouter, createWebHashHistory } from 'vue-router'

import Eliminar from '../components/Eliminar.vue'
import Estudiante from '../components/Estudiante.vue'
import Guardar from '../components/Guardar.vue'
import BienvenidaPage from '../components/BienvenidaPage.vue'
import NotFound from '../components/NotFoundPage.vue'
import Bloqueado from '../components/BloqueadoPage.vue'

const routes = [
    {
        path: '/eliminar',
        name: 'eliminar',
        component: Eliminar
    },
    {
        path: '/estudiante/:cedula',
        name: 'prueba',
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
    {
        path: '/:pathMatch(.*)*',
        component: NotFound
    },
    {
        path: '/bloqueado',
        name: 'block',
        component: Bloqueado
    }
]

const router = createRouter({
    history: createWebHashHistory(),
    routes
})

//programar guardianes
router.beforeEach((to, from, next) => {
    //
    console.log('Guardianaes');
    console.log(to);
    console.log(from);
    console.log(next);

    let usuario = 'bryan';
    let resultado = false;

    const random = Math.random() * 100;

    if (random > 50) {
        console.log('Si tiene acceso a esa pagina');
        next();
    } else {
        console.log('Acceso bloqueado');
        next({ name: 'block' })
    }
})

export default router