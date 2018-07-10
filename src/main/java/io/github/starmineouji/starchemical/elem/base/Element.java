package io.github.starmineouji.starchemical.elem.base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.base.Objects;

import io.github.starmineouji.starchemical.StarChemicalMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.resources.Locale;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * 
 * @author 原子のクラスです。
 *
 */
public class Element {
	/**
	 * 全原子
	 */
	public static Map<String, Element> elements = new HashMap<>();

	/**
	 * 原子を作成します。
	 * 
	 * @param name    原子名
	 * @param number  元素番号
	 * @param ESymbol 元素記号
	 */
	public Element(String name, int number, String ESymbol) {
		super();
		this.ESymbol = ESymbol;
		this.name = name;
		Number = number;
		BLOCK = new EBlock().setCreativeTab(StarChemicalMod.elems);
		ITEM = new EItem();
		IBLOCK = new ItemBlock(BLOCK).setRegistryName(StarChemicalMod.MODID, name.toLowerCase() + "_block")
				.setCreativeTab(StarChemicalMod.elems);
	}

	/**
	 * 原子を追加します。
	 * 
	 * @param name    原子名
	 * @param number  原子番号
	 * @param ESymbol 原子記号
	 * @return 追加された原子
	 */
	public static Element addElement(String name, int number, String ESymbol) {
		Element element = new Element(name, number, ESymbol);
		elements.put(ESymbol, element);
		return element;
	}

	/**
	 * すでに作成された原子を追加します。
	 * 
	 * @param e 原子
	 * @return 追加された原子
	 */
	public static Element addElement(Element e) {
		elements.put(e.ESymbol, e);
		return e;
	}

	/**
	 * 原子名
	 */
	protected String name,
			/**
			 * 原子記号
			 */
			ESymbol;

	/**
	 * 原子番号
	 */
	protected int Number;
	/**
	 * 原子ブロック
	 */
	protected Block BLOCK;
	/**
	 * 原子アイテム
	 */
	protected Item ITEM;
	/**
	 * アイテムブロック
	 */
	private Item IBLOCK;

	/**
	 * 原子ブロック
	 * 
	 * @author starmineouji
	 *
	 */
	public class EBlock extends Block {
		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return Objects.hashCode(name, ESymbol);
		}

		public EBlock() {
			super(Material.ROCK);
			// TODO Auto-generated constructor stub
			setRegistryName(StarChemicalMod.MODID, name.toLowerCase() + "_block").setUnlocalizedName(name.toLowerCase())
					.setHardness(1.5F).setResistance(1.0F);
		}
	}

	/**
	 * 原子アイテム
	 * 
	 * @author starmineouji
	 *
	 */
	public class EItem extends Item {
		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return Objects.hashCode(name);
		}

		public EItem() {
			// TODO Auto-generated constructor stub
			super();
			setRegistryName(StarChemicalMod.MODID, name.toLowerCase());
			setCreativeTab(StarChemicalMod.elems);
			setUnlocalizedName(name.toLowerCase());
		}
		@Override
		public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
			// TODO Auto-generated method stub
			if(worldIn != null &&!worldIn.isRemote) {
			Locale l = new Locale();
			tooltip.add(l.formatMessage("chemical.symbol", null)+":"+ESymbol);
			tooltip.add(l.formatMessage("chemical.atomicnum", null)+":"+Number);
			tooltip.add(l.formatMessage("chemical.name", null)+":"+name);
			}
			super.addInformation(stack, worldIn, tooltip, flagIn);
		}
	}

	public static Map<String, Element> getElements() {
		return elements;
	}

	public String getName() {
		return name;
	}

	public int getNumber() {
		return Number;
	}

	public Block getBlock() {
		return BLOCK;
	}

	public Item getItem() {
		return ITEM;
	}

	public Item getItemBlock() {
		return IBLOCK;
	}
}