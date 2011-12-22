package org.cfw.common
{
	public class ApplicationContext
	{
		public static var _instance:ApplicationContext;
		
		private var _currentMenuID:String;//菜单编码
		private var _activeTabID:String;//当前激活的moduleid
		public function ApplicationContext()
		{
			if(_instance != null) {
				throw new Error("Singleton");
			}
		}	
		
		public static function get currentMenuID():String
		{
			return getInstance()._currentMenuID;
		}

		public static function set currentMenuID(value:String):void
		{
			getInstance()._currentMenuID = value;
		}

		public static function getInstance():ApplicationContext {
			if(!_instance) {
				_instance = new ApplicationContext();
			}
			return _instance;
		}
	}
}