package bll;

import dao.ItemDAO;
import entity.Item;

public class  ItemBLL implements IBLL <Item> {

        @Override
	public int salvar(Item objeto) {
		ItemDAO itemDAO = new ItemDAO();
		return  itemDAO.salvar(objeto);
	}

}