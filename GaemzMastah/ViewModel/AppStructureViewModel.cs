using GaemzMastah.Model;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Windows.Input;

/// <summary>
/// This is the ViewModel which responsible for binding command to View
/// </summary>
namespace GaemzMastah.ViewModel
{   

    public class AppStructureViewModel
    {
        /// <summary>
        /// This is a list that has INotifyPropertyChanged implemented  
        /// </summary>
        public ObservableCollection<AppItem> GameList { get; set; }

        private ICommand command;
        public ICommand ClickCommand {
            get
            {
                return command ?? (command = new RelayCommand(p => RunApp(p)));
            }
        }

        /// <summary>
        /// Constructor for ViewModel
        /// </summary>
        public AppStructureViewModel()
        {
            GameList = new ObservableCollection<AppItem>(AppStructure.getApplicationItems());
        }

        /// <summary>
        /// The command in which to be run
        /// </summary>
        /// <param name="s">The abosulte path of application</param>
        private void RunApp(object s)
        {
            System.Diagnostics.Process pProcess=new System.Diagnostics.Process();
            pProcess.StartInfo.FileName = s.ToString();
            pProcess.Start();

        }




    }
}
