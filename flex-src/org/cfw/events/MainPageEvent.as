package org.cfw.events
{
	import flash.events.Event;
	
	import mx.controls.Image;
	import mx.modules.ModuleLoader;
	
	public class MainPageEvent extends Event
	{
		public static const LOADMENU:String = "loadMenu";
		public static const LOADIMAGE:String = "loadImage";
		public static const HOMEPAGE:String = "homepage";
		public static const MENUCLICK:String = "menuClick";
		
		public var url:String;
		public var moduleLoader:ModuleLoader;
		public var image:Image;
		public function MainPageEvent(type:String, bubbles:Boolean=true, cancelable:Boolean=false)
		{
			super(type, bubbles, cancelable);
		}

	}
}