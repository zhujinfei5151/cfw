package org.cfw.business
{
	import com.adobe.serialization.json.JSONDecoder;
	
	import flash.events.Event;
	import flash.net.URLLoader;
	import flash.net.URLLoaderDataFormat;
	import flash.net.URLRequest;
	import flash.utils.ByteArray;
	
	import mx.collections.ArrayCollection;
	import mx.controls.Image;
	import mx.controls.Menu;
	import mx.logging.Log;
	import mx.modules.ModuleLoader;
	import mx.rpc.events.ResultEvent;
	
	import org.cfw.events.MainPageEvent;

	public class MainPageManager
	{
		public function MainPageManager()
		{
		}
		[Bindable]
		public var menus:ArrayCollection;
		public var image:Image;
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
		
		public function loadImage(event:MainPageEvent):void {
			this.image = event.image;
			var loader:URLLoader = new URLLoader();
			loader.dataFormat = URLLoaderDataFormat.BINARY;
			configureListeners(loader);
			
			var request:URLRequest = new URLRequest(event.url);
			try {
				loader.load(request);
			} catch (error:Error) {
				trace("Unable to load requested document.");
			}
		}
		
		private function configureListeners(dispatcher:IEventDispatcher):void {
			dispatcher.addEventListener(Event.COMPLETE, completeHandler);
		}
		
		private function completeHandler(event:Event):void {
			var loader:URLLoader = URLLoader(event.target);
			var imageData:ByteArray = ByteArray(loader.data);
			image.data = imageData;
		}
	}
}