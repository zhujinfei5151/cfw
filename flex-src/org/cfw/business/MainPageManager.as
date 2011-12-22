package org.cfw.business
{
	import com.adobe.serialization.json.JSONDecoder;
	
	import org.cfw.events.MainPageEvent;
	
	import flash.events.Event;
	
	import mx.collections.ArrayCollection;
	import mx.controls.Menu;
	import mx.logging.Log;
	import mx.modules.ModuleLoader;
	import mx.rpc.events.ResultEvent;

	public class MainPageManager
	{
		public function MainPageManager()
		{
		}
		[Bindable]
		public var menus:ArrayCollection;
		public function showHomePage(event:MainPageEvent):void {
			
		}
		
		public function loadMenuData(result:Object):void {
			if(result == null) return;
			menus = result as ArrayCollection;
		}
		
		public function onMenuClick(event:MainPageEvent):void {
			trace(url);
			var url:String = event.url;
			var moduleLoader:ModuleLoader = event.moduleLoader;
			if(url == null) return ;
			var pos:int = url.indexOf(".");
			if(pos >=0) {
				url = url.substr(0,pos) + ".swf";
			}
			if(moduleLoader != null) {
				moduleLoader.unloadModule();
				moduleLoader.loadModule(url);
			}
		}
	}
}