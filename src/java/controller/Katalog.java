/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.TblAslab;

/**
 *
 * @author Khaer Ansori
 */
@ManagedBean
@SessionScoped
public class Katalog implements Serializable{
    
    @EJB
    private ItemFacade itemFacade;
    private TblAslab item = null;
    private List<TblAslab> items = null;
    private PagingInfo pagingInfo = null;

    /**
     * Creates a new instance of Catalog
     */
    public Katalog() {
        pagingInfo = new PagingInfo();
    }
    
    public PagingInfo getPagingInfo() {
        if(pagingInfo.getItemCount() == -1) {
            pagingInfo.setItemCount(getItemCount());
        }
        return pagingInfo;
    }
    
    public List<TblAslab> getNextItems(int maxResults, int firstResult) {
        return itemFacade.findRange(maxResults, firstResult);
    }
    
    public List<TblAslab> getItems() {
        if(items == null) {
            getPagingInfo();
            items = getNextItems(pagingInfo.getBatchSize(), pagingInfo.getFirstItem());
        }
        return items;
    }
    
    public TblAslab getItem() {
        return item;
    }
    
    public String next() {
        reset(false);
        getPagingInfo().nextPage();
        return "index";
    }
    
    public String prev() {
        reset(false);
        getPagingInfo().previousPage();
        return "index";
    }
    
    public String showDetail(TblAslab item) {
        this.item = item;
        return "detail";
    }
    
    public int getItemCount() {
        return itemFacade.getItemCount();
    }
    
    private void reset(boolean resetFirstItem) {
        item = null;
        items = null;
        pagingInfo.setItemCount(-1);
        if(resetFirstItem) {
            pagingInfo.setFirstItem(0);
        }
    }
    
    private ItemFacade getFacade() {
        return itemFacade;
    }
    
    public String prepareCreate() {
        item = new TblAslab();
        return "create";
    }
    
    public String create() {
        try {
            getFacade().create(item);
            return "index.xhtml?faces-redirect=true";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public String update() {
        try {
            getFacade().edit(item);
            return "detail";
        } catch (Exception e) {
            System.out.println("error");
            return null;
        }
    }
    
    private void performDestroy() {
        try {
            getFacade().remove(item);
        } catch (Exception e) {
            System.out.println("error");
        }
    }
    
    private void recreateModel() {
        items = null;
    }
    
    public String deleteAndView() {
        performDestroy();
        recreateModel();
        return "index";
    }
}
