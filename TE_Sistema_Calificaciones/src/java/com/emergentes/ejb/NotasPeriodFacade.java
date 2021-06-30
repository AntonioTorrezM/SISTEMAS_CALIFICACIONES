/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.ejb;

import com.emergentes.entidades.NotasPeriod;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author USUARIO
 */
@Stateless
public class NotasPeriodFacade extends AbstractFacade<NotasPeriod> {

    @PersistenceContext(unitName = "TE_Sistema_CalificacionesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NotasPeriodFacade() {
        super(NotasPeriod.class);
    }
    
}
