package org.cfw.common
{
	import mx.collections.ArrayList;

	public class PermissionVO
	{
		private var _moduleList:ArrayCollection;
		
		
		public function get moduleList():ArrayCollection
		{
			return _moduleList;
		}

		public function set moduleList(value:ArrayCollection):void
		{
			_moduleList = value;
		}

	}
}