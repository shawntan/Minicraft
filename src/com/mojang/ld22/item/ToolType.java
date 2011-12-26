package com.mojang.ld22.item;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.mojang.ld22.item.resource.Resource;

public class ToolType implements Serializable {
	public static final List<ToolType> ids = new ArrayList<ToolType>();
	public static ToolType shovel = new ToolType("Shvl", 0);
	public static ToolType hoe = new ToolType("Hoe", 1);
	public static ToolType sword = new ToolType("Swrd", 2);
	public static ToolType pickaxe = new ToolType("Pick", 3);
	public static ToolType axe = new ToolType("Axe", 4);

	public final String name;
	public final int sprite;
	
	public final int id;
	private ToolType(String name, int sprite) {
		this.name = name;
		this.sprite = sprite;
		
		this.id = ToolType.ids.size();
		ids.add(this);
	}
}
