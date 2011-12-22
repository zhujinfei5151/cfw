package org.cfw.business
{
	import com.adobe.serialization.json.JSONDecoder;
	
	import flash.events.Event;
	
	import mx.collections.ArrayCollection;
	import mx.controls.Menu;
	import mx.logging.Log;
	import mx.modules.ModuleLoader;
	import mx.rpc.events.ResultEvent;
	
	import org.cfw.events.TabEvent;

	public class TabManager
	{
		public function TabManager()
		{
		}
		[Bindable]
		public var tabs:ArrayCollection;
		
		public function loadTabData(result:Object):void {
			if(result == null) return;
			tabs = result as ArrayCollection;
		}
		
		public function onTabClick(event:TabEvent):void {
			trace(url);
			var url:String = event.url;
			var moduleLoader:ModuleLoader = event.moduleLoader;
			if(url == null) return ;
			var pos:int = url.indexOf("_init");
			if(pos >=0) {
				url = "org/cfw/" + url.substr(0,pos) + ".swf";
			}
			if(moduleLoader != null) {
				moduleLoader.unloadModule();
				moduleLoader.loadModule(url);
			}
		}
	}
}