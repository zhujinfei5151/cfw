package org.cfw.common
{
	public class ModulePermitVO
	{
		private var _moduleid:String;
		private var _mask:String;
		
		
		public function get moduleid():String
		{
			return _moduleid;
		}

		public function set moduleid(value:String):void
		{
			_moduleid = value;
		}

		public function get mask():String
		{
			return _mask;
		}

		public function set mask(value:String):void
		{
			_mask = value;
		}

	}
}