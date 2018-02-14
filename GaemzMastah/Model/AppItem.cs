
namespace GaemzMastah.Model
{
    /// <summary>
    /// Information about an application such as its name, icon, and full path.
    /// </summary>
    public class AppItem
    {
        /// <summary>
        /// The abosulte path of the application
        /// </summary>
        public string FullPath { get; set; }

        /// <summary>
        /// The name of the application
        /// </summary>
        public string Name { get; set; }

        /// <summary>
        /// The abosulte path of the application icon
        /// </summary>
        public string IconFullPath { get; set; }

        /// <summary>
        /// Constructor for AppItem
        /// </summary>
        /// <param name="v0">The abosulte path of the application</param>
        /// <param name="v1">The name of the application</param>
        /// <param name="v2">The abosulte path of the application icon</param>
        public AppItem(string v0, string v1, string v2)
        {
            FullPath = v0;
            Name = v1;
            IconFullPath = v2;
        }

    }
}
