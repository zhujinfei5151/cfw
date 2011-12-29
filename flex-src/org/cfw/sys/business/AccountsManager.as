package org.cfw.sys.business
{
	import com.adobe.serialization.json.JSONDecoder;
	
	import org.cfw.sys.events.AccountsEvent;
	
	import flash.events.Event;
	
	import mx.collections.ArrayCollection;
	import mx.controls.Menu;
	import mx.logging.Log;
	//import mx.modules.ModuleLoader;
	import mx.rpc.events.ResultEvent;

	public class AccountsManager
	{
		public function AccountsManager()
		{
		}
		[Bindable]
		public var accounts:ArrayCollection;
		
		
		public function queryAllAccountsData(result:Object):void {
			if(result == null) return;
			accounts = result as ArrayCollection;
		}
	}
}