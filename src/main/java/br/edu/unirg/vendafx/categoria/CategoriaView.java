/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unirg.vendafx.categoria;

import com.airhacks.afterburner.views.FXMLView;

/**
 *
 * @author rogerio
 */
public class CategoriaView extends FXMLView {
    
    public CategoriaPresenter getRealPresenter() {
        return (CategoriaPresenter) super.getPresenter();
    }
}
