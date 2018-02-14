using System.Collections.Generic;
using System.Xml;
using System;
namespace GaemzMastah.Model
{   
    /// <summary>
    /// This is the helper class to AppItem
    /// </summary>
    class AppStructure
    {   
        /// <summary>
        /// Gather information from Data.xml
        /// </summary>
        /// <returns> list of all applcations</returns>
        public static List<AppItem> getApplicationItems()
        {
            List<AppItem> listOfApplicaiton = new List<AppItem>();
            XmlReader reader = XmlReader.Create("D:\\Workspace\\GaemzMastah\\GaemzMastah\\Data\\Data.xml");
            while (reader.Read())
            {
                if ((reader.NodeType == XmlNodeType.Element) &&(reader.Name=="App"))
                {
                    if (reader.HasAttributes)
                    {
                        listOfApplicaiton.Add(new AppItem(reader.GetAttribute("fullPath"), reader.GetAttribute("name"),reader.GetAttribute("iconFullPath")));
                    }
                }
            }
            return listOfApplicaiton;
        }
    }
}
