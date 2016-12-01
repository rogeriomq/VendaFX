/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unirg.vendafx.cliente.clienteedit;

import com.airhacks.afterburner.views.FXMLView;

/**
 *
 * @author rogerio
 */
public class ClienteeditView extends FXMLView {
    
    public ClienteeditPresenter getRealPresenter() {
        return (ClienteeditPresenter) super.getPresenter();
    }
}
