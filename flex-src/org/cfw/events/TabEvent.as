package org.cfw.events
{
	import flash.events.Event;
	
	import mx.modules.ModuleLoader;
	
	public class TabEvent extends Event
	{
		public static const LOADTAB:String = "loadTab";
		public static const TABCLICK:String = "tabClick";
		
		public var url:String;
		public var moduleLoader:ModuleLoader;
		public function TabEvent(type:String, bubbles:Boolean=true, cancelable:Boolean=false)
		{
			super(type, bubbles, cancelable);
		}

	}
}